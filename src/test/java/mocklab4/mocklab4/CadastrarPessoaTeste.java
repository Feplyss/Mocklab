package mocklab4.mocklab4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {
	@Mock
	private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;
    
    @Test
    void validarDadosDeCadastro() {
    	DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("Rj", "Rio de Janeiro", "Rua 15, 2", "Apto 1321", "Madureira");
    	Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("654321")).thenReturn(dadosLocalizacao);
    	Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Rogerio", "123456", LocalDate.now(), "654321");
    	
    	assertEquals("Rogerio", pessoa.getNome());
    	assertEquals("123456", pessoa.getDocumento());
    	assertEquals("Madureira", pessoa.getEndereco().getBairro());
    }
}
