import pandas as pd

# name of files to read from and write to
r_filenameXLSX = 'D:\Class Docs\IP\IT 418\IT 418Feb20assign/realEstate_trans.xlsx'
w_filenameXLSX = 'D:\Class Docs\IP\IT 418\IT 418Feb20assign/realEstate_trans.xlsx'

# open the Excel file
xlsx_file = pd.ExcelFile(r_filenameXLSX)

# read the contents
xlsx_read = {
    sheetName: xlsx_file.parse(sheetName)
        for sheetName in xlsx_file.sheet_names
}

# print the first 10 prices for Sacramento
print(xlsx_read['Sacramento'].head(10)['price'])

# write to Excel
xlsx_read['Sacramento'] \
    .to_excel(w_filenameXLSX, 'Sacramento', index=False)