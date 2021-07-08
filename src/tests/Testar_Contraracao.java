package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class Testar_Contraracao {
	
	WebDriver driver;
	
	@Dado("^Acessar a página do Cadastro de Funcionarios$")
	public void acessar_a_página_do_Cadastro_de_Funcionarios() {
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://prjfinalteste-001-site1.ctempurl.com/Home/Exercicio02");
	}

	@Dado("^Selecionar o Funcionário \"([^\"]*)\"$")
	public void selecionar_o_Funcionário(String nome) {
		new Select(driver.findElement(By.id("Funcionario"))).selectByVisibleText(nome);
	}

	@Dado("^Selecionar o Tipo de Contratação \"([^\"]*)\"$")
	public void selecionar_o_Tipo_de_Contratação(String tipo) {
	    new Select(driver.findElement(By.id("TipoContratacao"))).selectByVisibleText(tipo);
	}

	@Quando("^Solicitar a gravação das alterações$")
	public void solicitar_a_gravação_das_alterações() {
	    driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
	}

	@Então("^Sistema informará os dados alterados com sucesso$")
	public void sistema_informará_os_dados_alterados_com_sucesso() {
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
	    assertEquals(mensagem, "Dados atualizados com sucesso");
	    
	    //evidencias
	    try {
	    	File evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(evidencia, new File("E:\\marcio_2021\\coti_Informatica\\Teste_Software_Sergio\\projeto_Final\\tarefa2\\evidencias\\tarefa2.png"));
	    }
	    catch(Exception e) {
	    	System.out.println(e.getMessage());
	    }
	}

	@Então("^Sistema informará que precisam preencher todos os campos$")
	public void sistema_informará_que_precisam_preencher_todos_os_campos() {
	    
		String NomeFuncionarioBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[1]/span")).getText();
		String TipoContratacaoBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[2]/span")).getText();
		
		//Assertivas
		assertEquals(NomeFuncionarioBranco, "Por favor, selecione o funcionário.");
		assertEquals(TipoContratacaoBranco, "Por favor, informe o tipo de contratação.");
	    
		 //evidencias
	    try {
	    	File evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(evidencia, new File("E:\\marcio_2021\\coti_Informatica\\Teste_Software_Sergio\\projeto_Final\\tarefa2\\evidencias\\tarefa2_Dados_Branco.png"));
	    }
	    catch(Exception e) {
	    	System.out.println(e.getMessage());
	    }
	}



}
