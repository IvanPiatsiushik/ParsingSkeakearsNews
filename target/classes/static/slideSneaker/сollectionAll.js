const bloks = document.querySelectorAll('.block')

for (const block of bloks){
    block.addEventListener('mouseover',()=>{

        removeFieldActive()
        block.classList.add('active')
    })
    block.addEventListener('mouseout',()=>{

        removeFieldActive()
        block.classList.remove('active')
    })
}

function removeFieldActive(){
    bloks.forEach((block)=>{
        block.classList.remove('active')
    })
}