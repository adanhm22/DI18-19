
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
	File /r "..\help"
	File /r "..\jasper"
	File "..\controladora.dat"
	File "..\dist\PruebasGraficas.jar"
	File /r "..\dist\lib"
	
	#creamos los enlaces directos
	createShortCut "$SMPROGRAMS\GestionCarreras\Desinstalar.lnk" "$INSTDIR\uninstall.exe"
	createShortCut "$SMPROGRAMS\GestionCarreras\Gestion.lnk" "$INSTDIR\uninstall.exe"
 	
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
	RmDir /r "$INSTDIR\help"
	RmDir /r "$INSTDIR\jasper"
	delete "$INSTDIR\controladora.dat"
	delete "$INSTDIR\PruebasGraficas.jar"
	RmDir /r "$INSTDIR\lib"
	
	#borramos los enlaces directos
	delete "$SMPROGRAMS\GestionCarreras\Gestion.lnk"
	delete "$SMPROGRAMS\GestionCarreras\Desinstalar.lnk"
	RmDir "$SMPROGRAMS\GestionCarreras"
	
	#borramos la carpeta de instalación
	RmDir "$INSTDIR"
	#borramos la clave del registro
	DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\GestionCarreras"
SectionEnd