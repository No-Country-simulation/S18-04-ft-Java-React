export default function Home() {
  return (
    <div
      data-testid="root-page"
      className="grid min-h-screen grid-rows-[20px_1fr_20px] items-center justify-items-center gap-16 p-8 pb-20 font-[family-name:var(--font-geist-sans)] sm:p-20">
      <main className="row-start-2 flex flex-col items-center gap-8 sm:items-start">
        <h1>Hola a todos</h1>
      </main>
    </div>
  );
}
