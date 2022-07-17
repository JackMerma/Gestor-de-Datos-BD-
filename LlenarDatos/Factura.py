import random

sql = "INSERT INTO `V2T_FACTURA` (`FacIde`, `FacImp`, `FacAño`, `FacMes`, `FacDia`, `FacEstReg`) VALUES ({ide}, {imp}, {anio}, '{mes}', '{dia}', 'A');"

year = [2019, 2020, 2021, 2022]
month = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
# Regresa un item a azar de la lista 'name


def selectRandom(names):
    return random.choice(names)


# nombre del archivo
f = open("LlenarDatos/Factura.sql", "w")

# intentando escribir en ese archivo
try:
    for i in range(3, 21):
        f.write(sql.format(ide=i, imp="100"+str(i), anio=selectRandom(year), mes=selectRandom(month), dia=i))
finally:
    f.close()
