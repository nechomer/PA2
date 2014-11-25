JAVA_PATH="/home/stas/programs/jdk1.7.0_45/bin"
mkdir bin
$JAVA_PATH/javac -d ./bin -classpath 'lib/gearley.jar' `find ./ -name "*.java"`
mkdir pa-2-myoutput
for f in $(ls pa-2-input | sed 's/.\{3\}$//')
do
	echo "********      TESTING $f      ********"
	$JAVA_PATH/java -classpath 'bin:lib/gearley.jar:src' Main pa-2-input/$f.ic > pa-2-myoutput/$f.out
	echo "diff -b pa-2-myoutput/$f.out pa-2-output/$f.ast "
	diff -b pa-2-myoutput/$f.out pa-2-output/$f.ast
done 
rm -rf bin
rm -rf pa-2-myoutput