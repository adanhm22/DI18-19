
#salida
outFile "Gestion de carreras.exe"

#carpeta de instalacion por defecto
installDir $PROGRAMFILES\GestionCarreras

#permisos de administración
RequestExecutionLevel admin

#pantallas que mostrar al usuario
Page directory
Page instfiles

#idioma español
!include "MUI.nsh"
!insertmacro MUI_LANGUAGE "Spanish"

Section
	#seleccionamos la carpeta de instalación
	SetOutPath $INSTDIR
	
	#escribimos el unistalador
	writeUninstaller "$INSTDIR\uninstall.exe"
	
	#añadimos los archivos que queremos en la instalación
	File /r "../help"
	File /r "../jasper"
	File /r "../jasper"
	File "../controladora.dat"
	
	#añadimos la información del registro
	WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\GestionCarreras" \
                 "DisplayName" "GestionCarreras"
	WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\GestionCarreras" \
                 "Publisher" "Adán - Desarrollo de interfaces"
	WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\GestionCarreras" \
                 "UninstallString" "$\"$INSTDIR\uninstall.exe$\""
	
SectionEnd


#definimos el desinstalador
Section "uninstall"
	#borramos el desinstalador
	delete "$INSTDIR\uninstall.exe"
	
	#borramos cada archivo individual
	delete "$INSTDIR\test.txt"
	
	#borramos la carpeta de instalación
	RmDir "$INSTDIR"
	#borramos la clave del registro
	DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\GestionCarreras"
SectionEnd