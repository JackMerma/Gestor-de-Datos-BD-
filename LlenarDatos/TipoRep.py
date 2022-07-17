import random

sql = "INSERT INTO `GZZ_TIPO_REPRESENTANTE_VENTAS` (`TipRepVenIde`, `TipRepVenDes`, `TipRepVenEstReg`) VALUES ({ide}, '{des}', 'A');"

descrip = ["A", "B", "C"]

# Regresa un item a azar de la lista 'name


def selectRandom(names):
    return random.choice(names)


# nombre del archivo
f = open("LlenarDatos/TipoReg.sql", "w")

# intentando escribir en ese archivo
try:
    for i in range(3, 21):
        f.write(sql.format(ide=i, des="Tipo"+selectRandom(descrip)))
finally:
    f.close()