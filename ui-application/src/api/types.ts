export interface Author {
  authorId: number;
  firstName: string;
  lastName: string;
  description: string;
}

export interface Category {
  categoryId: number;
  name: string;
  description: string;
}

export interface BookDTO {
  bookId: number;
  title: string;
  description: string;
  authors: Author[];
  categories: Category[];
}
