import random

sql = "INSERT INTO `V1M_REPRESENTANTE_VENTAS_DETALLE` (`RepVenDetIde`, `RepVenDetOfiIde`, `RepVenCabCarIde`, `RepVenDetRolRegIde`, `RepVenDetTipIde`, `RepVenDetUsuRegDetIde`, `RepVenDetNom`, `RepVenDetEdad`, `RepVenDetCon`, `RepVenDetDetObjRep`, `RepVenDetEstReg`) VALUES ('3', '3', '3', '3', '3', '3', 'repre3', '16', 'repre3', '6000', 'A');"

descrip = ["1", "2", "3"]

# Regresa un item a azar de la lista 'name


def selectRandom(names):
    return random.choice(names)


# nombre del archivo
f = open("LlenarDatos/RolReg.sql", "w")

# intentando escribir en ese archivo
try:
    for i in range(3, 21):
        f.write(sql.format(ide=i, des="rol"+selectRandom(descrip)))
finally:
    f.close()