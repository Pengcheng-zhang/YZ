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
   $("#shareModal").modal('show');
}