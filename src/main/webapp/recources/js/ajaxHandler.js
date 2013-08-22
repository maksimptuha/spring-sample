var ajaxHandler = (function(ajaxHandler) {
//    (function init() {
//        $('#answerForm').submit(function(event) {
//            event.preventDefault();
//
//        });
//    })()

    ajaxHandler.questionLike = function() {
        $.getJSON('/questions/like', {questionId : $('#questionId').val()}, function(likes) {
                $('#question-likes span').text(likes);
        });
    }

    ajaxHandler.questionDislike = function() {
        $.getJSON('/questions/dislike', {questionId : $('#questionId').val()}, function(likes) {
            $('#question-likes span').text(likes);
        });
    }

    ajaxHandler.answerLike = function(answerId) {
        $.getJSON('/answers/like', {answerId : answerId}, function(likes) {
            $('#answer-likes-' + answerId).find('span').text(likes);
        });
    }

    ajaxHandler.answerDislike = function(answerId) {
        $.getJSON('/answers/dislike', {answerId : answerId}, function(likes) {
            $('#answer-likes-' + answerId).find('span').text(likes);
        });
    }

    return ajaxHandler;
})(ajaxHandler || {});
