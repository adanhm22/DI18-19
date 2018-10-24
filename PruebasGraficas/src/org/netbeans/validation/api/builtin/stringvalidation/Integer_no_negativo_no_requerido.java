/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.validation.api.builtin.stringvalidation;

import org.netbeans.validation.api.Problems;
import org.openide.util.NbBundle;

/**
 *
 * @author alumnop
 */
public class Integer_no_negativo_no_requerido extends StringValidator {

    @Override
    public void validate(Problems prblms, String compName, String model) {
        try {
            if (!"".equals(model.trim())) {
                int numero = Integer.parseInt(model);
                if (numero < 0) {
                    String mensaje = NbBundle.getMessage(Integer_no_negativo_no_requerido.class, "NUMERO_NEGATIVO", compName);
                    prblms.add(mensaje);
                }
            }

        } catch (NumberFormatException e) {
            String mensaje = NbBundle.getMessage(Integer_no_negativo_no_requerido.class, "NO_ES_NUMERO", compName,model);
            prblms.add(mensaje);

        }
    }

}
