
angular.module('dpApp').component('mmMoviesList', {
	  templateUrl: 'app/movie/movieList.html',
	  controller:  ['$scope','movieListService','$location',
	                function($scope, movieListService, $location) {
		  
		  $scope.service = movieListService;
		  
		  movieListService.loadMovies().then(function(result) {
		       $scope.result = result;
		    });
		}]
	});

angular.module('dpApp').service('movieListService', ['$http','$sce',
                                                       function($http, $sce) {
	this.loadMovies = function(){		
		var req = {
				method : 'GET',				
				url : 'rest/movies'
			}
		
		return $http(req).then(function(response) {
			return response.data;
		});
	}
}]);