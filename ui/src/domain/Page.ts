class Page<T> {
  pageIndex: number;
  itemsPerPage: number;
  totalItems: number;
  totalPages: number;
  currentItemCount: number;
  items: T[];
}

export default Page;
