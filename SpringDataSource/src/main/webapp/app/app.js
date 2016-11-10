angular.module('dpApp', ['ngRoute','ngMessages','ngMaterial','ngSanitize'])
.constant('socialShareUrl', {
    'facebookShareUrl': 'https://www.facebook.com/sharer.php?u=',
    'twitterShareUrl': 'https://twitter.com/intent/tweet?url=',
    'googlePlusShareUrl': 'https://plus.google.com/share?url='
});

angular.module('dpApp').run([function(){
	
}]);