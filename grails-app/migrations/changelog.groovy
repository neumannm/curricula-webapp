databaseChangeLog = {
    changeSet(author: "mandy (generated)", id: "1548687418332-1") {
        addColumn(tableName: "programmes") {
            column(name: "summary", type: "text")
        }
    }
}
