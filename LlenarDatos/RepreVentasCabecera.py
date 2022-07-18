
import random

sql = "INSERT INTO `V1M_REPRESENTANTE_VENTAS_CABECERA` (`RepVenCabFacIde`, `RepVenCabRepIde`, `RepVenCabEstReg`) VALUES ({facIde}, {repIde}, 'A');"

cant = [5, 10, 15, 20, 25, 30, 35, 40, 45, 50,
        55, 60, 65, 70, 75, 80, 85, 90, 95, 100]


# Regresa un item a azar de la lista 'name


def selectRandom(names):
    return random.choice(names)


# nombre del archivo
f = open("LlenarDatos/RepreVentasCabecera.sql", "w")

# intentando escribir en ese archivo
try:
    for i in range(3, 21):
        f.write(sql.format(facIde=i, repIde=i))
finally:
    f.close()
