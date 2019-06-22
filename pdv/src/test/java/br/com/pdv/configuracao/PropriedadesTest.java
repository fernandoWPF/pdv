package br.com.pdv.configuracao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PropriedadesTest {

    @Test
    public void testGetConfiguracoes() {
        Assert.assertNotNull(Propriedades.getConfiguracoes());
    }

}
