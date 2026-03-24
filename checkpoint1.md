# CP01 - Navigation Compose

## Descrição do projeto
Aplicativo Android desenvolvido para estudar navegação entre telas, com base no filme Interestelar, apresentando informações gerais, curiosidades e perfil do usuário.

## Objetivo da prova
O objetivo da prova é demonstrar o entendimento e aplicação de navegação entre telas e passagem de parâmetros.

## Tela de Perfil com parâmetros
Na tela de perfil, foi implementado o código referente a passagem de parâmetros obrigatórios e o de múltiplos parâmetros.

### Definindo parâmetros na MainActivity

```kotlin
composable(
    route = "perfil/{nome}/{idade}",
    arguments = listOf(
        navArgument("nome") {
            type = NavType.StringType
        },
        navArgument("idade") {
            type = NavType.IntType
        }
    )
) {
    val nome: String? = it.arguments?.getString("nome", "Usuário genérico")
    val idade: Int? = it.arguments?.getInt("idade", 0)

    PerfilScreen(
        modifier = Modifier.padding(innerPadding),
        navController,
        nome!!,
        idade!!
    )
}
```

* **Rota:** `"perfil/{nome}/{idade}"` → define os placeholders que a tela espera, neste caso "nome" e "idade".

* **arguments:** representa a lista de parâmetros passados à tela.

* **navArgument("nome"):** nome do argumento, deve ser igual ao da rota.

* **type = NavType.StringType:** cada argumento tem um tipo e ele é passado no type, de forma simplificada, ele define o tipo do parâmetro.

* **valores nulos:** no perfil, `nome` e `idade` são **nullable** (`String?`, `Int?`). Usando `!!` é possível "forçar" o Kotlin a tratá-los como não nulos:

```kotlin
PerfilScreen(
    modifier = Modifier.padding(innerPadding),
    navController,
    nome!!,
    idade!!
)
```

* **tratamento de valores nulos:** para não ter problemas com valores nulos, foram definidos valores default para os dois parâmetros  (`"Usuário genérico"` e `0`).

---

### **Enviando parâmetros do perfil**

É no menu que esses parâmetros estão sendo enviados, por meio do `navController.navigate`, antes nele era passado somente a rota, agora são passados também os valores correspondentes aos parâmetros.

* Exemplo: `perfil/Ana Maria/21`

```kotlin
Button(
    onClick = { navController.navigate("perfil/Ana Maria/21") },
    modifier = Modifier.size(width = 200.dp, height = 48.dp)
) {
    Text(
        text = "Perfil",
        fontSize = 20.sp
    )
}
```

---

### **Recebendo os parâmetros na tela destino**

No caso do perfil, os parâmetros foram concatenados com o texto que já era exibido inicialmente.

```kotlin
Text(
    text = "Bem-vindo, \n $nome ($idade anos)",
    fontSize = 24.sp,
    fontWeight = FontWeight.Bold,
    textAlign = TextAlign.Center,
    color = Color.White
)
```
---

## Tela de Filme com parâmetros
Na tela de perfil, foi implementado o código referente a passagem de parâmetros opcionais.

### Definindo parâmetros na MainActivity
```kotlin
composable(
    route = "filme?cliente={cliente}",
    arguments = listOf(navArgument("cliente") {
        defaultValue = "Cliente sem login"
    })
) {
    FilmeScreen(
        modifier = Modifier.padding(innerPadding),
        navController,
        it.arguments?.getString("cliente")
    )
}

```

* **Rota:** `"filme?cliente={cliente}"` define o placeholder que a tela espera, neste caso "cliente".

* **arguments:** novamente, representa a lista de parâmetros passados à tela.

* **defaultValue = "Cliente sem login":** permite definir um valor default caso nada seja passado.

* **navArgument("cliente"):** novamente, representa o nome do argumento, que deve ser igual ao da rota.

---

### **Enviando parâmetros do filme**

```kotlin
Button(
    onClick = { navController.navigate("filme") },
    modifier = Modifier.size(width = 200.dp, height = 48.dp)
) {
    Text(
        text = "Sobre o Filme",
        fontSize = 20.sp
    )
}
```

Repare que agora não tem nenhum parâmetro sendo passado no `navController.navigate`, logo a premissa é que na tela seja exibido o valor default estabelecido.

---

### **Recebendo os parâmetros na tela destino**

Na tela do filme foi feito o mesmo processo de exibição, logo, o valor do parâmetro também foi concatenado com o texto inicial.

```kotlin
Text(
    text = "Filme Interestelar \n ($cliente)",
    fontSize = 26.sp,
    fontWeight = FontWeight.Bold,
    textAlign = TextAlign.Center,
    color = Color.White
)
```
