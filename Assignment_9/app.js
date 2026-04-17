var app = angular.module("myApp", []);

app.service("ContactService", function () {
    var id = 1;
    var contacts = [{
        id: 0,
        name: "Soham Rajput",
        email: "sohamrjp@gmail.com",
        password: "Soham@112",
        phone: "7821923100",
        age: "20"
    }];

    this.list = () => contacts;

    this.save = function (c) {
        if (!c.id) {
            c.id = id++;
            contacts.push(c);
        } else {
            for (var i in contacts) {
                if (contacts[i].id == c.id) {
                    contacts[i] = c;
                }
            }
        }
    };

    this.get = id => contacts.find(c => c.id == id);

    this.delete = id => {
        for (var i in contacts) {
            if (contacts[i].id == id) {
                contacts.splice(i, 1);
            }
        }
    };
});

app.controller("ContactController", function ($scope, ContactService) {

    $scope.contacts = ContactService.list();
    $scope.newcontact = {};

    $scope.saveContact = function () {
        if (!$scope.newcontact) return;
        ContactService.save($scope.newcontact);
        $scope.newcontact = {};
    };

    $scope.delete = function (id) {
        ContactService.delete(id);
    };

    $scope.edit = function (id) {
        $scope.newcontact = angular.copy(ContactService.get(id));
    };
});