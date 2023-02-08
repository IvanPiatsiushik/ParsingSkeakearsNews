const upBtn = document.querySelector('.up-button')
const downBtn = document.querySelector('.down-button')
const siedbar = document.querySelector('.sidebar')
const mainSlide = document.querySelector('.main-slide')
const slideCount = mainSlide.querySelectorAll('div').length
const container = document.querySelector('.con')

console.log(slideCount)

let activeSlideIndex = 0
siedbar.style.top = `-${(slideCount -1)*100}vh`

upBtn.addEventListener('click',()=>{
    changeSlide('up')
})
downBtn.addEventListener('click',()=>{
    changeSlide('down')
})

document.addEventListener('keydown',event =>{
    if (event.key === 'ArrowUp'){
        changeSlide('up')
    } else if (event.key === 'ArrowDown'){
        changeSlide('down')
    }
})
function changeSlide(direction){
    if (direction === 'up'){
        activeSlideIndex++
        if (activeSlideIndex === slideCount){
            activeSlideIndex = 0
        }
    } else if (direction === 'down'){
        activeSlideIndex--
        if (activeSlideIndex < 0)
            activeSlideIndex = slideCount - 1
    }
    const height = container.clientHeight
    mainSlide.style.transform = `translateY(-${activeSlideIndex * height}px)`
    siedbar.style.transform = `translateY(${activeSlideIndex * height}px)`

}
