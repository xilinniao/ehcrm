function ShowMaxDialog(url, windowName) {
    var iTop = (window.screen.height - 400) / 2;
    var iLeft = (window.screen.width - 400) / 2;
    var openWindow = window.open(url, windowName, "Scrollbars=yes ,Toolbar=no,Location=no,Direction=no,resizable =yes, Width=" + 400 + " ,Height=" + 400 + ",top=" + iTop + ",left=" + iLeft);
    if (document.all){
        openWindow.moveTo(0,0)
        openWindow.resizeTo(screen.width+8,screen.height-30)
    }
    openWindow.focus();
}

function ShowFullScrean(url, windowName) {
    var openWindow = window.open(url, windowName, "left=0px,top=0px,fullscreen=1,toolbar=0,location=0,directories=0,status=0,menuBar=0,scrollBars=1,resizable=1");
    openWindow.focus();
}