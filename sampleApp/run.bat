@echo off
for /f "usebackq tokens=1,2 delims==" %%a in ("dbCred.env") do (
  set "%%a=%%b"
)
call .\mvnw spring-boot:run