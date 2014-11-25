@ECHO off
mkdir pa-2-myoutput
del pa-2-myoutput\*.ic.out
FOR %%a in (pa-2-input/*.ic) do (
   echo ********      TESTING %%a      ********
	java -cp bin;lib\gearley.jar;src Main pa-2-input/%%a > pa-2-myoutput/%%a.out
	echo.
	echo diff -b pa-2-myoutput/%%a.out pa-2-output/%%~na.ast
	diff -b pa-2-myoutput/%%a.out pa-2-output/%%~na.ast
   echo =================================================================
)

echo ********      TESTING Library      ********
	java -cp bin;lib\gearley.jar;src Main pa-2-input/empty_prog.ic -Lpa-2-input/libic.sig > pa-2-myoutput/libic.ic.out
	echo.
	echo diff -b pa-2-myoutput/libic.ic.out pa-2-output/libic.ast
	diff -b pa-2-myoutput/libic.ic.out pa-2-output/libic.ast
echo =================================================================