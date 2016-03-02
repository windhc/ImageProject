/**
 * Created by Administrator on 2015/8/3.
 */
$(function(){
    $('.nav li a').click(function(){
        $('.nav li').removeClass('active');
        $(this).parent().addClass('active');
    })
});