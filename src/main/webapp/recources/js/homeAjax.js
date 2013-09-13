var homeAjax = (function(homeAjax) {
    homeAjax.deleteQuestion = function(url) {
        $.getJSON(url, function(questionId) {
            $('div.question-' + questionId).remove();
        });
    };

    return homeAjax;
})(homeAjax || {});

