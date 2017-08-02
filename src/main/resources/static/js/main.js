var themeApp = {
    featuredMedia: function () {
        $(".post").each(function () {
            var e = $(this), t = $(this).find("featured"), i = t.find($("img")), n = t.find("iframe");
            i.length > 0 ? ($(i).insertAfter(e.find(".post-head")).wrap("<div class='featured-media'></div>"), e.addClass("post-type-image"), t.remove()) : n.length > 0 && ($(n).insertAfter(e.find(".post-head")).wrap("<div class='featured-media'></div>"), e.addClass("post-type-embeded"))
        })
    }, responsiveIframe: function () {
        $(".post").fitVids()
    }, sidebarConfig: function () {
        1 == sidebar_left && ($(".main-content").addClass("col-md-push-4"), $(".sidebar").addClass("col-md-pull-8"))
    }, recentPost: function () {
        var e = String("");
        $.get("/rss/", function (t) {
            $(t).find("item").slice(0, recent_post_count).each(function () {
                var t = ($(this).find("description").text(), $(this).contentSnippet, $(this).find("link").text()),
                    i = $(this).find("title").text(), n = $(this).find("pubDate").text();
                e += '<div class="recent-single-post">', e += '<a href="' + t + '" class="post-title">' + i + '</a><div class="date">' + function (e) {
                        var t = new Date(e);
                        return ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"][t.getMonth()] + " " + t.getDate() + ", " + t.getFullYear()
                    }(n) + "</div>", e += "</div>"
            }), $(".recent-post").html(e)
        })
    }, highlighter: function () {
        $("pre code").each(function (e, t) {
            hljs.highlightBlock(t)
        })
    }, backToTop: function () {
        $(window).scroll(function () {
            $(this).scrollTop() > 100 ? $("#back-to-top").fadeIn() : $("#back-to-top").fadeOut()
        }), $("#back-to-top").on("click", function (e) {
            return e.preventDefault(), $("html, body").animate({scrollTop: 0}, 1e3), !1
        })
    }, init: function () {
        themeApp.featuredMedia(), themeApp.responsiveIframe(), themeApp.highlighter(), themeApp.backToTop()
    }
};
$(document).ready(function () {
    themeApp.init()
});
