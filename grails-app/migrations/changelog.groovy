databaseChangeLog = {
	changeSet(author: 'mandy', id: 'modules.ects') {
		comment {'Change data type of ects column' }
		modifyDataType(tableName: 'modules', columnName: 'ects', newDataType: 'float(10)')
	}
}
