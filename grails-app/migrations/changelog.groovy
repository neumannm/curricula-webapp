databaseChangeLog = {
	changeSet(author: "mandy (generated)", id: "1554115975859-1") {
        addColumn(tableName: "universities") {
            column(name: "type", type: "varchar(5)") {
                constraints(nullable: "true")
            }
        }
    }
}
