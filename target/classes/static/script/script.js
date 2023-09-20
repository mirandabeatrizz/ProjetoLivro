    document.getElementById('adicionarLivro').addEventListener('click', function(){
        const tituloInput = document.getElementById('titulo');
        const autorInput = document.getElementById('autor');
        const descricaoInput = document.getElementById('descricao');
        const categoriaInput = document.getElementById('categoria');
        const isbnInput = document.getElementById('isbn');
        const anoPublicacaoInput = document.getElementById('anoPublicacao');

        const titulo = tituloInput.value;
        const autor = autorInput.value;
        const descricao = descricaoInput.value;
        const categoria = categoriaInput.value;
        const isbn = isbnInput.value;
        const anoPublicacao = anoPublicacaoInput.value;

        fetch('/api/livros/adicionar', {
            method: 'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                titulo: titulo,
                autor: autor,
                descricao: descricao,
                categoria: categoria,
                isbn: isbn,
                anoPublicacao: anoPublicacao
            })
        })

        .then(response => response.json())
        .then (data => {
            window.confirm(`Livro ${data.titulo} adicionado com sucesso!`);
            tituloInput.value = '';
            autorInput.value = '';
            descricaoInput.value = '';
            categoriaInput.value = '';
            isbnInput.value = '';
            anoPublicacaoInput.value = '';

        })
        .catch(error => {
            console.error('Erro ao criar produto:', error);
        });


    });