const books= document.querySelectorAll(".book-container");
const filter= document.querySelector(".filter-items");

filter.addEventListener("click",(event)=>{
    if (!event.target.classList.contains("active") && event.target.classList.contains("filter-item")) {
       document.querySelector(".active").classList.remove("active");
       event.target.classList.add("active");
      
    }
    const filterValue= event.target.getAttribute("data");
    books.forEach(book=>{
      if (event.target.classList.contains("filter-item")) {
        if (book.classList.contains(filterValue) || filterValue==="All")  {
            book.classList.remove("hide");
            book.classList.add("show");
        }else{
            book.classList.remove("show");
            book.classList.add("hide");
        }
      }
    })

})

profile.addEventListener("click",()=>{
    profileModal.classList.toggle("active-modal");
    backDrop.classList.toggle("back-drop_active");
})

backDrop.addEventListener("click",()=>{
    profileModal.classList.remove("active-modal");
    backDrop.classList.remove("back-drop_active");
})