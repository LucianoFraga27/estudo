package br.com.stoica.estudy.jasper;

import java.util.HashMap;
import java.util.Locale;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.stoica.estudy.pessoa.Pessoa;
import br.com.stoica.estudy.pessoa.PessoaService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class PessoaJasperImpl implements PessoaJasper {

    @Autowired
     private PessoaService pessoaService;

    @Override
    public byte[] gerarRelatorioPessoas(Pageable pageable) {
        
        /*
         * é necessário ter criado um modelo de relátorio no jasper reports
         * Ao criar o modelo devemos colocar o mesmo nome dos atributos e tipos nos fields do relatório
         * compile o report: arquivo.jrxml
         * pegue o relatorio compilado e jogue dentro de algum lugar no projeto, no caso joguei em resources/relatorios/jasper
        */

        try {
            var inputStream = this.getClass().getResourceAsStream("/relatorios/jasper/pessoas.jasper");

            var parameters = new HashMap<String, Object>();
            parameters.put("REPORT_LOCALE", new Locale("pt","BR"));
            
            List<Pessoa> pessoas = (List<Pessoa>) pessoaService.findAll(pageable).getContent();
            var dataSource = new JRBeanCollectionDataSource(pessoaService.findAll(pageable).getContent());

            var jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource);
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (JRException e) {
            
        }

        return null;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'gerarRelatorioPessoas'");
    }
    
}
