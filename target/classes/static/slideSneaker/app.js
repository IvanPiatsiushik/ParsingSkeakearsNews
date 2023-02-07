const bloks = document.querySelectorAll('.block')

for (const block of bloks){
    block.addEventListener('click',()=>{

        removeFieldActive()
        block.classList.add('active')
    })
}

function removeFieldActive(){
    bloks.forEach((block)=>{
        block.classList.remove('active')
    })
}