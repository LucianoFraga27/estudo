package br.com.stoica.estudy.email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class EmailConfig {
    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    /*
 * 1. Abra o Prompt de Comando:
 * 2. Para definir as variáveis de ambiente, execute o seguinte comando:
 *    $ setx PASSWORD_SENHA_DE_APP "senha"
 *    $ setx EMAIL_SENHA_DE_APP "email"
 * 3. Feche o Prompt de Comando atual e abra um novo para garantir que as variáveis de ambiente sejam carregadas corretamente.
 * 4. Para verificar se as variáveis foram definidas corretamente, execute os seguintes comandos no novo Prompt de Comando:
 *    $ echo %PASSWORD_SENHA_DE_APP%
 *    $ echo %EMAIL_SENHA_DE_APP%
 * Se as variáveis de ambiente foram definidas corretamente, esses comandos deverão exibir os valores correspondentes que você definiu.
 */


}
