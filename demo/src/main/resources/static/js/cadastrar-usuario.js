$(document).ready( 
    $('[name="btn-enviar"]').on("click", () => {
        if ($('[name="nome"]').val() == null || $('[name="nome"]').val() == ""){
            alert("nome nao preenchido")
            console.log("nome nao preenchido")
            return 
        }
    
        if ($('[name="email"]').val() == null || $('[name="email"]').val() == ""){
            alert("email nao preenchido")
            console.log("email nao preenchido")
            return 
        }
    
        if ($('[name="senha1"]').val() == null || $('[name="senha1"]').val() == ""){
            alert("senha nao preenchida")
            console.log("senha nao preenchida")
            return 
        }
    
        if ($('[name="senha2"]').val() == null || $('[name="senha2"]').val() == ""){
            alert("senha nao preenchida")
            console.log("senha nao preenchida")
            return 
        }

        if ($('[name="senha2"]').val() != $('[name="senha2"]').val()){
            alert("senhas não coincidem")
            console.log("Vasco")
            return
        }
        
    
        request_data = {
            nome: $('[name="nome"]').val(),
            email: $('[name="email"]').val(),
            senha1: $('[name="senha1"]').val(),
            senha2: $('[name="senha2"]').val()
        }
    
        console.log(request_data)

        $.ajax({
            url: $(location).attr('href'),
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(
                {
                    nome: $('[name="nome"]').val(),
                    email: $('[name="email"]').val(),
                    senha1: $('[name="senha1"]').val(),
                    senha2: $('[name="senha2"]').val()
                }
            ),
            dataType: "json",
            success: (response) => {
                alert(response["mensagem"])
                window.location.href="/"
            },
            error: (response) => {
                alert(response["responseJSON"]["mensagem"])
                console.log(response)
            }
        })
    })
)