/**
 * Created by 张鹏程 on 2017/8/2.
 */
function artPrise(url, id) {
   $.post(url,{
       id: id
   },function(data, status){

   });
}

function artPunish(url, id) {
   $.post(url, {
       id: id,
   }, function(data, status){

   });
}

function artShare(url, id) {
   $("#shareModal .modal-title").text($('#art-'+id).find('.content-title').text());
   $("#shareModal .modal-body").text($('#art-'+id).find('.content-p').html());
   $("#shareModal").modal('show');
}

function artComment(comment,id) {
    $.post('/art/'+id+'/comment', {
       id: id,
       comment: comment
    },function(data, status) {
        if (data.result) {
            toast('评论成功');
        }else{
            toast(data.message);
        }
    });
}

function toast(message) {
    $('.warning-box').html(message);
    $('.warning-box').stop().fadeIn(300);
    clearTimeout(t);
    var t = setTimeout(function () {
        $('.warning-box').fadeOut(300)
    }, 1000);
}