import argparse
import os
import subprocess
from datetime import datetime
import sys
import pickle
from argparse import RawTextHelpFormatter


def write_in_file(file_name: str, in_list: list) -> None:
    """
    Метод записывает в файл регистрации список и размер зарегистрированных дисков
    :param file_name - имя файла регистрации
    :param in_list - список дисков для записи. В каждой ячейке списка лежит кортеж из имени диска и размера в гигабайтах
    :return None
    """
    cwd = sys.path[0]
    with open(f"{cwd}/{file_name}", 'wb') as f:
        pickle.dump(in_list, f)
    print("Файл регистрации обновлён.")


def read_from_file(file_name: str) -> list:
    """
    Метод читает из файла регистрации список и размер зарегистрированных дисков
    :param file_name - имя файла регистрации
    :return item_list - список дисков. В каждой ячейки списка лежит кортеж из имени диска и его размера в гигабайтах.
    """
    cwd = sys.path[0]
    with open(f"{cwd}/{file_name}", 'rb') as f:
        item_list = pickle.load(f)
    return item_list


def get_current_disk_list() -> list:
    """
    Метод читает из системы список и размер дисков
    :param None
    :return disk_list - список дисков. В каждой ячейки списка лежит кортеж из имени диска и его размера в гигабайтах.
    """
    command_result = subprocess.check_output("lsblk -b -n -d -o NAME,SIZE", shell=True)
    data_list = command_result.decode("utf-8").split()
    # Превращение строки в массив, а потом в массив кортежей для рассчёта  размеров
    disk_list = list()
    for i in range(0, len(data_list), 2):
        if data_list[i].find("loop") == -1:
            a_line = (data_list[i], round(int(data_list[i+1])/1024**3, 2))
            disk_list.append(a_line)
    return disk_list


def show_current_disk_list(file_name: str, format_string: str) -> None:
    """
    Метод выводит список дисков в системе и зарегистрированных дисков
    :param file_name - имя файла регистрации
    :param format_string - строка форматирования для вывода таблицы
    :return None
    """
    disk_list = get_current_disk_list()
    file_data_list = read_from_file(file_name)
    print("Сравнительная таблица дисков:")
    print(format_string.format("Текущие диски", "Зарегистрированные диски"))
    if len(file_data_list) <= len(disk_list):
        for i in range(0, len(disk_list)):
            if i < len(file_data_list):
                print(format_string.format(f"{disk_list[i][0]}[{disk_list[i][1]} Gb]", f"{file_data_list[i][0]}[{file_data_list[i][1]} Gb]"))
            else:
                print(format_string.format(f"{disk_list[i][0]}[{disk_list[i][1]} Gb]", "[-------]"))
    else:
        for i in range(0, len(file_data_list)):
            if i < len(disk_list):
                print(format_string.format(f"{disk_list[i][0]}[{disk_list[i][1]} Gb]", f"{file_data_list[i][0]}[{file_data_list[i][1]} Gb]"))
            else:
                print(format_string.format("[-------]", f"{file_data_list[i][0]}[{file_data_list[i][1]} Gb]"))


def disk_partitions_clear(disk_name: str) -> bool:
    """
    Метод очищает таблицу разделов и заголовок диска
    :param disk_name - имя диска
    :return True/False в зависимости от успешности
    """

    if not os.system(f"sudo umount /dev/{disk_name}*"):
        if not os.system(f"sudo wipefs -af /dev/{disk_name}"):
            print("Таблицы разделов диска успешно удалены!")
            return True
        else:
            print("Ошибка удаления таблицы разделовю")
    else:
        print("Ошибка освобождения диска.")
    return False


def get_unregistrated_disk_list(file_name: str) -> list:
    """
    Метод возвращает список новых дисков, составленный из списка дисков и списка регистрации
    :param file_name - имя файла регистрации
    :return list кортежей имени и размера дисков
    """

    new_disks_list = list()
    # Выполнение команды и получение строки значений
    print("lsblk функционирует нормально")
    disk_list = get_current_disk_list()
    if os.path.exists(f"{sys.path[0]}/{file_name}"):
        file_data_list = read_from_file(file_name)
        show_current_disk_list(file_name, FORMAT_STRING)
        if len(file_data_list) <= len(disk_list):
            for i in range(0, len(disk_list), 1):
                if i >= len(file_data_list):
                    new_disks_list.append((disk_list[i][0], disk_list[i][1]))
        else:
            print("Диск/диски не найдены")
    return new_disks_list


def last_disk_configuration(file_name: str) -> None:
    """
    Метод полностью настраивает последний из незарегистрированных дисков
    :param file_name - имя файла регистрации
    :return None
    """
    new_disks_list = get_unregistrated_disk_list(file_name)
    if len(new_disks_list):
        last_disk = new_disks_list[-1][0]
        print(f"Конфигурация диска:{new_disks_list[0][0]}[{new_disks_list[0][1]} Gb]...")
        disk_configuration(last_disk)


def disk_configuration(disk_name: str) -> bool:
    """
    Метод полностью настраивает диск по его имени
    :param disk_name - имя диска
    :return True/Flase в зависимости от успешности
    """
    if disk_partitions_clear(disk_name):
        # Разметка диска здесь!
        if not os.system(f"sudo parted -s /dev/{disk_name}"):
            print("Диск успешо открыт")
            if not os.system(f"sudo parted -s /dev/{disk_name} mklabel msdos"): 
                print("Заголовок успешно записан")
                if not os.system(f"sudo parted -s /dev/{disk_name} mkpart primary ext4 0% 100% && sudo mkfs.ext4 -q -F /dev/{disk_name}1"):
                    print("Диск успешно размечен")
                    if not os.system("sudo mkdir -p /media/partedDisk"):
                        print("Директория создана")
                        if not os.system(f"sudo mount /dev/{disk_name}1 /media/partedDisk"):
                            print("Диск установлен")
                            if not os.system("sudo chmod -R -v 777 /media/partedDisk"):
                                print("Права доступа установленны")
                                if not os.system("mkdir -p /media/partedDisk/videos"):
                                    print("Папка videos создана")
                                    if not os.system("sudo umount /media/partedDisk"):
                                        print("Очистка завершена")
                                        return True
                                    else:
                                        print("Ошибка очистки! Удалите оставшийся диск partedDisk вручную.")
                                else:
                                    print("Ошибка создания папки videos. Проверьте права доступа.")
                            else:
                                print("Ошибка установки прав доступа. Проверьте правиьность монтирования диска.")
                        else:
                            print("Ошибка установки диска.")
                    else:
                        print("Ошибка создания временной директории для монтирования диска")
                else:
                    print("Ошибка разметки диска")
            else:
                print("Ошибка записи заголовка диска.")
        else:
            print("Ошибка открытия диска")
    return False


def update_disk_registration(file_name: str) -> None:
    """
    Метод обновляет файл регистрации дисков
    :param file_name - имя файла регистрации
    :return None
    """
    disk_list = get_current_disk_list()
    write_in_file(file_name, disk_list)


def main_body_hand_mode(file_name: str, format_string: str) -> None:
    """
    Метод реализует ручной выбор и настройку диска
    :param file_name - имя файла регистрации
    :param format_string - строка форматирования для вывода таблицы
    :return None
    """
    disk_list = get_current_disk_list()
    # Если файл регистрации существует
    if os.path.exists(f"{sys.path[0]}/{file_name}"):
        file_data_list = read_from_file(file_name)
        new_disks_list = list()
        is_old_longer = False
        show_current_disk_list(file_name, format_string)
        if len(file_data_list) <= len(disk_list):
            for i in range(len(disk_list)):
                if i >= len(file_data_list):
                    new_disks_list.append((disk_list[i][0], disk_list[i][1]))
        else:
            for i in range(len(file_data_list)):
                if i >= len(disk_list):
                    is_old_longer = True
        # Если найдены новые диски или конфигурация дисков изменилась с прошлого раза/скрипт запущен на новой системе?
        if len(new_disks_list):
            print("WARNING! В обнаружен новый диск!")
            for i, (disk_name, disk_size) in enumerate(new_disks_list):
                print(f"{i} : {disk_name} [{disk_size} Gb]")
            print("Хотите ли вы обновить список зарегистрированных дисков?")
            answer = input("[yes/no]")
            if answer == "yes":
                write_in_file(file_name, disk_list)
            else:
                print("Хотите выбрать диск для разметки?")
                answer = input("[yes/no]")
                if answer == "yes":
                    # ДОБАВИТЬ ВЫБОР ДИСКОВ!
                    if len(new_disks_list) == 1:
                        print(f"Найден только один диск: {new_disks_list[0][0]}[{new_disks_list[0][1]} Gb]. Хотите разметить этот диск?")
                        answer = input("[yes/no]")
                        if answer == "yes":
                            disk_configuration(new_disks_list[0][0])
                    else:
                        # Если дисков несколько
                        print(f"Найдены несколько дисков. Количество: {len(new_disks_list)}. Список дисков:")
                        for i, (disk_name, disk_size) in enumerate(new_disks_list):
                            print(f"{i} : {disk_name}[{disk_size} Gb]")
                        print("Хотите ли вы разметить все диски?")
                        answer = input("[yes/no]")
                        if answer == "yes":
                            for i, (disk_name, disk_size) in enumerate(new_disks_list):
                                print(f"{i} : {disk_name} [{disk_size} Gb] - разметка...")
                                disk_configuration(disk_name)
                            print("Диски размечены")
                        else:
                            print(f"Введите номер диска для конфигурации. Номер должен быть от 0 до {len(new_disks_list)-1}.")
                            answer = input(f"Номер должен быть от 0 до {len(new_disks_list)-1}: ")
                            while not (answer.isdigit() and 0 <= int(answer) < len(new_disks_list)):
                                print(f"Номер должен быть числовым и быть от 0 до {len(new_disks_list)-1}!")
                                print("Введите число заново!")
                                answer = input(f"Номер должен быть от 0 до {len(new_disks_list)-1}: ")
                            print(f"Выбран диск {answer} {new_disks_list[int(answer)][0]} [{new_disks_list[int(answer)][1]} Gb]")
                            disk_configuration(new_disks_list[int(answer)][0])
        # Если новых дисков нет
        else:
            print("Новые диски не найдены")
            if is_old_longer:
                # Если старый список дисков длиннее нового, то обновить файл
                print("Система обнаружила регистрации дисков, но диски не обнаружены. Обновить файл регистрации?")
                answer = input("[yes/no]")
                if answer == "yes":
                    write_in_file(file_name, disk_list)
    else:
        print("Файл регистрации дисков не обнаружен!")
        print("Хотите записать новый файл?")
        answer = input("[yes/no]")
        if answer == "yes":
            write_in_file(file_name, disk_list)


def partition_all_disks(file_name: str) -> bool:
    """
    Метод реализует размету всех незарегистрированных дисков
    :return True/False в зависимости от успешности
    """
    new_disks_list = get_unregistrated_disk_list(file_name)
    is_success = True
    if len(new_disks_list):
        for i, (disk_name, disk_size) in enumerate(new_disks_list):
            print(f"{i} : {disk_name} [{disk_size} Gb] - разметка...")
            if not disk_configuration(disk_name):
                is_success = False
        print("Диски размечены")
        if is_success:
            return True
        else:
            print("Конфигурация одного или нескольких дисков не завершилась успехом.")
    else:
        print("Дисков нет")
    return False


# --help - справка и руководство +
# -u - обновление списка регистрации дисков +
# -l - перезаписать последний из новых дисков +
# -a - перезаписать все новые диски +
# -m - ручной режим работы +
# -v - вывод списка дисков и регистраций +
# Константы для форматированного вывода и файла регистрации
FORMAT_STRING = "{:16} : {:16}"
FILE_NAME = "disk_log.pickle"
# Тело программы
if __name__ == "__main__":
    if not os.system("lsblk -V"):
        now = datetime.now()
        dt_string = now.strftime("%d/%m/%Y %H:%M:%S")
        # Выполнение команды и получение строки значений
        print("lsblk функционирует нормально")
        parser = argparse.ArgumentParser(description="Разметка дисков", formatter_class=RawTextHelpFormatter,
        epilog=('''
        Использование
        
        python3 diskConfig.py [option] - работа в безопасном режиме

        Программа размечает диск для работы с SOVA.
        
        На диске создается один раздел ext4, в нём создаётся папка videos и на диск устанавливаются права доступа.
        
        Пояснение о регистрации:
        Во избежание крайне нежелательного форматирования системных дисков, программа регистрирует список системных дисков в специальный файл. При подключении нового диска, программа сверяет список дисков со списком зарегистрированных дисков и позволяет работать только с незарегистрированными дисками.
        '''))
        group = parser.add_mutually_exclusive_group(required=True)
        group.add_argument("-u", action="store_true", help="Обновление файла списка регистрации дисков. Выполнять без "
                                                           "подключения предназначенного для разметки диска")
        group.add_argument("-l", action="store_true", help="Разметить писледний/единственный из незарегистрированных "
                                                           "дисков. Использовать после подключения диска, "
                                                           "который требуется разметить.")
        group.add_argument("-a", action="store_true", help="Разметить все незарегистрированные диски. Использовать с "
                                                           "осторожностью!")
        group.add_argument("-m", action="store_true", help="Ручной режим работы.")
        group.add_argument("-v", action="store_true", help="Вывод списка дисков и регистраций")
        args = parser.parse_args()
        
        if args.v:
            show_current_disk_list(FILE_NAME, FORMAT_STRING)
        elif args.l:
            last_disk_configuration(FILE_NAME)
        elif args.a:
            partition_all_disks(FILE_NAME)
        elif args.u:
            update_disk_registration(FILE_NAME)
        else:
            main_body_hand_mode(FILE_NAME, FORMAT_STRING)
    else:
        print("lsblk не функционирует")
    

    