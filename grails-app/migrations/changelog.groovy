databaseChangeLog = {
    changeSet(author: "mandy (generated)", id: "1548685164053-1") {
            addColumn(tableName: "programmes") {
                column(name: "key_aspect", type: "varchar(31)") {
                    constraints(nullable: "false")
                }
            }
        }

    changeSet(author: "mandy (generated)", id: "1548685164053-2") {
        addUniqueConstraint(columnNames: "name", constraintName: "UC_COUNTRIESNAME_COL", tableName: "countries")
    }
}
