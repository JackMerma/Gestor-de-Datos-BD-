import random



sql = "INSERT INTO `GZZ_CARGO` (`CarIde`, `CarDes`, `CarSue`, `CatEstReg`) VALUES ({id}, '{des}', '{sueldo}', 'A');"

direcciones = ["Paucarpata", "M. Melgar", "Cerro Colorado", "Yanahuara"]

objetivos = [10000, 15000, 20000, 25000]

ventas = [500, 600, 700, 800, 900, 1000]

categorias= ["A", "B", "C", "D"]

sueldos = [4000, 4500, 5000, 5500]

## Regresa un item a azar de la lista 'name
def selectRandom(names):
  return random.choice(names)

## nombre del archivo
f = open("LlenarDatos/cargo.sql", "w")

## intentando escribir en ese archivo
try:
  for i in range(3,21):
    f.write(sql.format(id=i, des="Vendedor"+selectRandom(categorias), sueldo=selectRandom(sueldos)))
finally:
  f.close()



