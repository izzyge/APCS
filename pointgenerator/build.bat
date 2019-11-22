@echo off
REM Build batch file for PointGenerator

@echo on
javac RFileIo.java
@echo off
if errorlevel 1 goto fail

@echo on
javac RLine.java
@echo off
if errorlevel 1 goto fail

@echo on
javac RRectangle.java
@echo off
if errorlevel 1 goto fail

@echo on
javac RElipse.java
@echo off
if errorlevel 1 goto fail

@echo on
javac RShape.java
@echo off
if errorlevel 1 goto fail

@echo on
javac PointGenerator.java
@echo off
if errorlevel 1 goto fail

REM All is well, go to the success block
goto success

REM Display fail message and exit.
:fail
echo BUILD FAILED
goto done

REM Display Success message and exit.
:success
echo BUILD PASSED
goto done

:done
