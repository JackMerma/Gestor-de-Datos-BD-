# flags

JC = javac
JCFLAGS =

JVM = java
JVMFLAGS = -cp 
SQLCONNECT = .:lib/mysql-connector-java-8.0.28.jar

# targets

.SUFFIXES: .java .class

# target entry for .class

.java.class:
	$(JC) $(JCFLAGS) $*.java

# classes macro

CLASSES = \
			 Main.java \
			 src/controlador/Controlador.java \
			 src/modelo/CategoriaCliente.java \
			 src/modelo/CategoriaClienteDAO.java \
			 src/modelo/Conexion.java \
			 src/vista/Vista.java

# default make target entry

default: classes

# suffix replacement within macro

classes: $(CLASSES:.java=.class)

# running

run: 
	$(JVM) $(JVMFLAGS) $(SQLCONNECT) Main

# rm -f

clean:
	find . -name '*.class' -exec rm -rf {} \;
