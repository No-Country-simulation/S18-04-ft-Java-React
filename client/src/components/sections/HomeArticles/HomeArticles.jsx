import { HomeArticle } from '@/components/HomeArticle/HomeArticle';

export const HomeArticles = () => (
  <section className="mt-8 flex w-full flex-col items-center justify-center gap-y-7">
    <HomeArticle
      title="Simulación Laboral"
      description="Explora nuevas simulaciones y elige tu próximo desafío."
    />
    <HomeArticle
      title="Noticias y novedades"
      description="Mantente al día con las últimas actualizaciones y oportunidades de networking."
    />
  </section>
);
