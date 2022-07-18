import random

sql = "INSERT INTO `V1M_REPRESENTANTE_VENTAS_DETALLE` (`RepVenDetIde`, `RepVenDetOfiIde`, `RepVenCabCarIde`, `RepVenDetRolRegIde`, `RepVenDetTipIde`, `RepVenDetUsuRegDetIde`, `RepVenDetNom`, `RepVenDetEdad`, `RepVenDetCon`, `RepVenDetDetObjRep`, `RepVenDetEstReg`) VALUES ({ide}, {ofiIde}, {cargoIde}, {rolRegIde}, {tipoIde}, {usuIde}, '{name}', '{edad}', '{contrato}', '{objetivo}', 'A');"

descrip = ["1", "2", "3"]

anios = ["2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"]
mes = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"]
dias = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"]

edad = ["20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40"]

objetivos = [1000, 2000, 3000, 1500, 1200]

## una lista de 20 elementos
ids = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]

# Regresa un item a azar de la lista 'name


def selectRandom(names):
    return random.choice(names)


# nombre del archivo
f = open("LlenarDatos/RepresentanteVentasDetalle.sql", "w")

# intentando escribir en ese archivo
try:
    for i in range(3, 21):
        # f.write(sql.format(ide=i, ofiIde=selectRandom(ids), cargoIde=selectRandom(ids), rolRegIde=selectRandom(ids), tipoIde=selectRandom(ids), usuIde=selectRandom(ids), name="repre"+str(i), edad=selectRandom(edad), contrato=selectRandom(anios)+"-"+selectRandom(mes)+"-"+selectRandom(dias), objetivo=selectRandom(objetivos)))
        f.write(sql.format(ide=i, ofiIde=i, cargoIde=i, rolRegIde=i, tipoIde=i, usuIde=i, name="repre"+str(i), edad=selectRandom(edad), contrato=selectRandom(anios)+"-"+selectRandom(mes)+"-"+selectRandom(dias), objetivo=selectRandom(objetivos)))
finally:
    f.close()