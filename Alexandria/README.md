# Alexandria

It's a barcode scanner App for books.  

### Critical point (need fix)

- Alexandria crash when searching a book and there is no connection [**FIXED**]
- The scan functionality doesn't work (Only display a toast)

#### Extra Error cases found

- Improved delete book feature checking the EAN (length != 10, start with 978) inside BookService
- Notify data set changes on OnResume of ListBooks

### For Extra point

- Fix Alexandria barcode scanning with no third party app installation required
- Find extra error cases and highlight it into code through comments

### Note 

- For now I decided to not change UI, to better focus