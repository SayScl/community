/**
 * Created by Administrator on 2017/7/12.
 */




var blogs_spacerank_index = 0,
    blogs_spacerank_class = 'a10 wrap ';
var blogs_spacerank_list = document.getElementById('blogs_spacerank').getElementsByTagName('a');
function blogs_spacerank_ck(_idx) {
    blogs_spacerank_list[blogs_spacerank_index].className = blogs_spacerank_class;
    blogs_spacerank_list[_idx].className = blogs_spacerank_class + ' cur wid';
    document.getElementById('blogs_spacerank_' + blogs_spacerank_index).style.display = 'none';
    document.getElementById('blogs_spacerank_tab_' + blogs_spacerank_index).innerHTML = document.getElementById('blogs_spacerank_tab_' + blogs_spacerank_index).innerHTML.replace("空间排行", "");
    document.getElementById('blogs_spacerank_' + _idx).style.display = 'block';
    document.getElementById('blogs_spacerank_tab_' + _idx).innerHTML = document.getElementById('blogs_spacerank_tab_' + _idx).innerHTML;
    blogs_spacerank_index = _idx;
}

function change(t){
  var curr=$(t).val();
  setContentTab('two',curr, 7)
}


function setContentTab(name, curr, n) {
    for (i = 1; i <= n; i++) {
        var menu = document.getElementById(name + i);
        var cont = document.getElementById("con_" + name + "_" + i);
        menu.className = i == curr ? "hover" : "";
        if (i == curr) {
            cont.style.display = "block";
        } else {
            cont.style.display = "none";
        }
    }
}



