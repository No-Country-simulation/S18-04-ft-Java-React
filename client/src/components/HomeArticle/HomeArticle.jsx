import Link from 'next/link';
import Button from '../Button/Button';

export const HomeArticle = ({ title, description, children }) => (
  <article className="mx-auto flex min-h-36 w-full max-w-[90%] items-start justify-between gap-x-4 rounded-2xl bg-primary-500 p-4">
    <div className="flex flex-1 basis-3/5 flex-col gap-y-2">
      <h3 className="text-gradient gradient-green-blue-400 text-left text-2xl font-medium">
        {title}
      </h3>
      <h4 className="w-fit text-pretty text-left text-sm leading-6 min-[600px]:text-base">
        {description}
      </h4>
    </div>
    {children}
  </article>
);
