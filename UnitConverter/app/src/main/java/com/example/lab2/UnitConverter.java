package com.example.lab2;

public class UnitConverter {
    double[] longs = new double[4];
    double[][][] convers = new double[4][4][3];

    double[] masses = new double[4];


    double[] volumes = new double[4];

    // устанавливаем значения элементов массива
    public UnitConverter()
    {
        longs[0] = SIZES.METER.getSize(); // метр
        longs[1] = SIZES.INCH.getSize(); // дюйм
        longs[2] = SIZES.FOOT.getSize(); //фут
        longs[3] = SIZES.YARD.getSize(); //ярд

        masses[0] = SIZES.KILOGR.getSize(); // килограмм
        masses[1] = SIZES.FUNT.getSize(); // фунт
        masses[2] = SIZES.OZT.getSize(); //унция
        masses[3] = SIZES.STOUNE.getSize(); //стона

        volumes[0] = SIZES.LITRA.getSize(); // литр
        volumes[1] = SIZES.GALLON.getSize(); // галлон
        volumes[2] = SIZES.QUART.getSize(); //кварта
        volumes[3] = SIZES.PINT.getSize(); //пинта

        for(int i=0; i<4; i++)
        {
            for(int j=0; j<4; j++)
            {
                    convers[i][j][0] = longs[i] / longs[j];
                    convers[i][j][1] = masses[i] / masses[j];
                    convers[i][j][2] = volumes[i] / volumes[j];
            }
        }
    }


    public Unit Convert(Unit inUnit, SIZES outSize){
        if (inUnit.getSize().getType() == outSize.getType()) {
            double numb = convers[outSize.getNumb()][inUnit.getSize().getNumb()][outSize.getType()];
            Unit outUnit = new Unit(outSize, numb * inUnit.getNumber());
            return outUnit;
        }
        else
        {
            return null;
        }
    }

}
