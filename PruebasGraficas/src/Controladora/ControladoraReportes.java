/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.Carrera;
import Modelo.CarreraFinalizada;
import Modelo.CarreraSinFinalizar;
import Modelo.Dorsal;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author adan
 */
public class ControladoraReportes {
    
    
    public void reportCarrerasSinFinalizar(File rutaDestino) throws JRException{
        List<CarreraSinFinalizar> carrerasSinFinalizadar = DataSource.getCarrerasSinFinalizadar();
        JRDataSource dataSource = new JRBeanCollectionDataSource(carrerasSinFinalizadar);
        Map parametros = new HashMap();
        JasperPrint print = JasperFillManager.fillReport
        ("jasper"+File.separator+"reportCarrerasSinFinalizar.jasper", parametros,dataSource);
        JasperExportManager.exportReportToPdfFile(print,rutaDestino.getAbsolutePath());
        
    }

    public void reportCarrera(File rutaDestino, Carrera carrera) throws JRException {
        Map parametros = new HashMap();
        List<Dorsal> corredores = carrera.getCorredores();
        JRDataSource dataSource = new JRBeanCollectionDataSource(corredores);
        parametros.put("finalizada", carrera instanceof CarreraFinalizada);
        JasperPrint print = JasperFillManager.fillReport
        ("jasper"+File.separator+"informeSobreCarrera.jasper", parametros,dataSource);
        JasperExportManager.exportReportToPdfFile(print,rutaDestino.getAbsolutePath());
    }
    
}
