let studentName = document.querySelector(".name");
let studentId = document.querySelector(".id");
let book = document.querySelector(".book");
let phoneNumber = document.querySelector(".phone");
let borrowBtn = document.querySelector(".borrow-btn");
let verifyName = document.querySelector(".verify_name");
let verifyId = document.querySelector(".verify_id");
let verifyPhone = document.querySelector(".verify_phone");
let verifybook = document.querySelector(".verify_book");
let verifiactionModal= document.querySelector(".verifiaction");
let backDrop = document.querySelector(".back-drop");
let cancelBtn = document.querySelector(".verificatoin-cancel");

borrowBtn.addEventListener("click",(e)=>{

    verifiactionModal.style.display="grid";
    backDrop.style.display="block";
    backDrop.style.opacity ="1";

   if (studentName.value.length===0) {
       verifyName.innerHTML= `Name: empty`;
    } else {
       verifyName.innerHTML= `Name: ${studentName.value}`;
   }
   
   if (studentId.value.length===0) {
       verifyId.innerHTML= `Id: empty`;
    } else {
       verifyId.innerHTML= `Id: ${studentId.value}`;
   }
   if (phoneNumber.value.length===0) {
       verifyPhone.innerHTML= `Phone: empty`;
    } else {
       verifyPhone.innerHTML= `Phone: ${phoneNumber.value}`;
   }
   if (book.value.length===0) {
       verifybook.innerHTML= `Book: empty`;
    } else {
       verifybook.innerHTML= `Book: ${book.value}`;
   }

})


backDrop.addEventListener("click",()=>{
       backDrop.style.display="none";
        verifiactionModal.style.display ="none";   
})
    
cancelBtn.addEventListener("click",()=>{  
     backDrop.style.display="none";
     verifiactionModal.style.display ="none";
})


