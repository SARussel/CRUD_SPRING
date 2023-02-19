$(document).ready(function (){
    const toogleLangBtn = $('#toogle-lang');
    const addNewEmployeeBtn = $('#add-a-new');
    toogleLangBtn.click(function (){
        window.location.href = lang === LANG.en.prefix ? rootURL+"?lang="+LANG.bn.prefix : rootURL+"?lang=" + LANG.en.prefix;
    });
    addNewEmployeeBtn.on('click', () => {
       window.location.href = "/add-employee";
    });
});