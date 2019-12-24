/**
 *
 */

function init(){
	var e = document.armorShopForm.equip // 装備リストのチェックボックス取得
	var len = e.length; // 装備リストのチェックボックスの個数
	var checkedLen = 0;
	for (var i = 0; i < len; i++) {
		if (document.getElementById(i).value == "true") {
			e[i].checked = true;
			document.getElementById("sobityu" + i).style.display = "inline";
			checkedLen += 1;
		} else {
			e[i].checked = false;
			document.getElementById("sobityu" + i).style.display = "none";
		}
	}

	if (checkedLen == 2) {
		// 2つチェックされた時点で他は触れなくする
		for (var i = 0; i < len; i++) {
			if (!e[i].checked) {
				e[i].disabled = true;
			}
		}
	} else {
		// 他の時は触れるように
		for (var i = 0; i < len; i++) {
				e[i].disabled = false;
		}
	}
}
// チェックボックスの制御、チェックされたら装備中文言の制御、隠し項目の制御
function checkLimit(){
	var e = document.armorShopForm.equip // 装備リストのチェックボックス取得
	var len = e.length; // 装備リストのチェックボックスの個数
	var checkedLen = 0;
	for (var i = 0; i < len; i++) {
		if (e[i].checked) {
			document.getElementById(i).value = "true";
			document.getElementById("sobityu" + i).style.display = "inline";
			checkedLen += 1;
		} else {
			document.getElementById(i).value = "false";
			document.getElementById("sobityu" + i).style.display = "none";
		}
	}

	if (checkedLen == 2) {
		// 2つチェックされた時点で他は触れなくする
		for (var i = 0; i < len; i++) {
			if (!e[i].checked) {
				e[i].disabled = true;
			}
		}
	} else {
		// 他の時は触れるように
		for (var i = 0; i < len; i++) {
				e[i].disabled = false;
		}
	}
}

function showDetails(){
	// 別ウィンドウで一覧
	window.open('/Kensyu3/PlayServlet3','詳細一覧','top=100,left=100,width=600');
}

function closeLog() {
	// モーダルみたいな使い方。JavaのIFで表示、閉じるボタンで消す。
	document.getElementById("msgBuyWindow").style.display = "none";
}